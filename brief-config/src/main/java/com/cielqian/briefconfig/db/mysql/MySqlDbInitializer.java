package com.cielqian.briefconfig.db.mysql;

import com.cielqian.briefconfig.db.DbInitializer;
import org.json.JSONObject;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
@Component
public class MySqlDbInitializer implements DbInitializer {

    public static JSONObject mysqlPro ;

    static {
//        String  basePath =  System.getProperty("user.dir")    ;
//        String dirName = basePath   +  "/conf/jdbc.properties";
//        mysqlPro = PropertiesUtils.parse(dirName);
    }

    @Override
    public Boolean isInitialized() {
        if(mysqlPro.containsKey("dbtype") ){
            if("mysql".equalsIgnoreCase(mysqlPro.get("dbtype").toString())){
                if(!mysqlPro.containsKey("ip") || !mysqlPro.containsKey("dbname")
                        ||!mysqlPro.containsKey("username") ||!mysqlPro.containsKey("password") ){
                    return null ;
                }
                IDBcontrolled mc  = createIDBcontrolled();
                MysqlRstData mysqlRstData = mc.testConn(mysqlPro) ;　　　　　　　　　　//数据库存在，不存在dbname的库
                if(  mysqlRstData.getCode() .equals(MysqlRstData.ResultCode.NO_DB)){
                    if(!mysqlPro.containsKey("init")){
                        return null ;
                    }
                    mysqlRstData =mc.createDB(mysqlPro);
                    if(   mysqlRstData.getCode() .equals(MysqlRstData.ResultCode.SUCCESS)  ){
                        mysqlRstData  = mc.importDB(mysqlPro);

                    }
                }
                if(  !mysqlRstData.getCode() .equals(MysqlRstData.ResultCode.SUCCESS)){
                    return null ;
                }

                SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

                BasicDataSource dataSource = new BasicDataSource();
                dataSource.setUrl( String.format(MysqlDBUtil.baseurl,mysqlPro.getString("ip"),
                        mysqlPro.getString("port"),mysqlPro.getString("dbname")) );

                dataSource.setDriverClassName(MysqlDBUtil.driver);
                dataSource.setUsername(mysqlPro.getString("username")  );
                dataSource.setPassword(mysqlPro.getString("password")  );
                dataSource.setRemoveAbandoned(false);
                dataSource.setInitialSize(Utils.getInt(mysqlPro.getString("initialSize"), 5));//初始化的连接数
                dataSource.setMaxActive(Utils.getInt(mysqlPro.getString("maxActive"), 10));//最大连接数量
                dataSource.setMaxIdle(Utils.getInt(mysqlPro.getString("maxIdle"), 10));//最大空闲数
                dataSource.setMinIdle(Utils.getInt(mysqlPro.getString("minIdle"), 5));//最小空闲

                dataSource.setMaxWait(Utils.getInt(mysqlPro.getString("maxWait"), 3000));
                dataSource.setRemoveAbandoned(Utils.getBoolean(mysqlPro.getString("removeAbandoned")));
                dataSource.setRemoveAbandonedTimeout(Utils.getInt(mysqlPro.getString("removeAbandonedTimeout"), 180));
                dataSource.setValidationQuery(mysqlPro.getString("validationQuery"));
                dataSource.setTestOnBorrow(Utils.getBoolean(mysqlPro.getString("testOnBorrow"), true));
                dataSource.setLogAbandoned(Utils.getBoolean(mysqlPro.getString("logAbandoned"), true));
                this.dbConnectFlag = true ;
                return dataSource;
            }
        }
        return null ;
    }


        return null;
    }

    @Override
    public Boolean initialze() {
        return null;
    }
}
