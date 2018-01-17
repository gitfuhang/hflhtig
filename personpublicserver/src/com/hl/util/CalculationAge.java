package com.hl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 根据出生日期计算年龄计算年龄
 * @author Administrator
 *
 */
public class CalculationAge {
	
	private static Logger logger = Logger.getLogger(CalculationAge.class);
	
	public static int getAgeByBirth(String userBirthday) {
		try {
			
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//  
		Date dateBirthday=sdf.parse(userBirthday);				
        int age = 0;
        
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(dateBirthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
           logger.info("计算年龄错误:"+e.toString());
           return 0;
        }
    }
}
