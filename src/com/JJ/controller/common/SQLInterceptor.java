package com.JJ.controller.common;

import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Base;
@Intercepts(value=
{@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class/*, RowBounds.class, ResultHandler.class*/}),
})
public class SQLInterceptor implements Interceptor {
	private static final Logger logger = Logger.getLogger(SQLInterceptor.class);
	private static int MAPPED_STATEMENT_INDEX = 0;
    private static int PARAMETER_INDEX = 1;
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		logger.debug("SQLInterceptor");
		Object[] queryArgs = invocation.getArgs();
		if(queryArgs[MAPPED_STATEMENT_INDEX] instanceof MappedStatement){
			MappedStatement mappedStatement = (MappedStatement)queryArgs[MAPPED_STATEMENT_INDEX];
			String sql = mappedStatement.getBoundSql(queryArgs[PARAMETER_INDEX]).getSql().trim();
			logger.debug(sql);
			if (mappedStatement == null || mappedStatement.getSqlCommandType() == null) {  
	            return invocation.proceed();  
	        }  
			if(mappedStatement.getSqlCommandType().equals(SqlCommandType.UPDATE)){
				if(queryArgs[PARAMETER_INDEX] instanceof Base){
					Base base = (Base)queryArgs[PARAMETER_INDEX];
					if(base.getDeleteind() == null){
						base.setDeleteind(GeneralUtils.NOT_DELETED);
					}
					Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					if(principal instanceof UserDetails){
						UserDetails user = (UserDetails)principal;
						base.setUpdatedon(new Date());
						base.setUpdatedby(user.getUsername());
						if(base.getVersion() == null){
							base.setVersion(1);
						}else{
							base.setVersion(base.getVersion()+1);
						}
					}
				}
			}else if(mappedStatement.getSqlCommandType().equals(SqlCommandType.INSERT)){
				if(queryArgs[PARAMETER_INDEX] instanceof Base){
					Base base = (Base)queryArgs[PARAMETER_INDEX];
					if(base.getDeleteind() == null){
						base.setDeleteind(GeneralUtils.NOT_DELETED);
					}
					Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					if(principal instanceof UserDetails){
						UserDetails user = (UserDetails)principal;
						base.setUpdatedon(new Date());
						base.setUpdatedby(user.getUsername());
						base.setCreatedby(user.getUsername());
						base.setCreatedon(new Date());
						base.setVersion(1);
					}
				}
			}
		}
		
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub

	}

}
