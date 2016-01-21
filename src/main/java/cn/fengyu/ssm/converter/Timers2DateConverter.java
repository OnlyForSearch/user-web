package cn.fengyu.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**时间戳格式转换为Date
 * @author fengyu
 * @since 2016-01-21
 */
public class Timers2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        long timestamp = 0;
        try {
            timestamp = Long.parseLong(source);
            return new Date(timestamp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

       return null;
    }
}
