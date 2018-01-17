package com.hl.util;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class timesampFilter implements Filter{
	private static final Logger logger = Logger.getLogger(timesampFilter.class);
    public void init(FilterConfig fConfig) throws ServletException {}
    public void destroy() {}
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
         
        String requestURL = req.getRequestURL().toString();
        String queryStr = req.getQueryString();
         
        // add timestamp to static resource, to avoid cache
        if(requestURL != null && (requestURL.endsWith(".js") || requestURL.endsWith(".css"))){  // static resource
            String newURL = null;
            if(StringUtils.isNotBlank(queryStr) && queryStr.trim().indexOf(ParameterConfig.STATIC_TAIL) == -1){
                newURL = requestURL + "?" + queryStr + "&" + ParameterConfig.STATIC_TAIL + new Date().getTime();
                resp.sendRedirect(newURL);
                return;
            }
            if(StringUtils.isBlank(queryStr)){
                newURL = requestURL + "?" + ParameterConfig.STATIC_TAIL + new Date().getTime();
                resp.sendRedirect(newURL);
                return;
            }
             
            try{
                chain.doFilter(request, response);
            }catch(Exception e){
                logger.error(e.toString());
            }
            return;
        }
    }
}
