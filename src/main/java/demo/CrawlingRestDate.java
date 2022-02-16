package demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 爬取网上的星期休息日等
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 9:41 2021/12/1
 * @since 1.0.0
 */
public class CrawlingRestDate {
    public static void main(String[] args) {

        String year = "2021";

        String template = "INSERT INTO `kaoqin`.`kq_person_rest_day_t`(`rest_day`) VALUES ('{}');\n";

        Set<String> holidayAndWeekSet = new HashSet<>();

        Calendar c = Calendar.getInstance();

        c.set(Integer.parseInt(year), 0, 1);

        Calendar c2 = Calendar.getInstance();

        c2.set(Integer.parseInt(year) + 1, 0, 1);

        // 1. 获取全部周六周末
        while (c.compareTo(c2) < 0) {
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                String month = (c.get(Calendar.MONTH) + 1) > 9 ? String.valueOf(c.get(Calendar.MONTH) + 1) : ("0" + (c.get(Calendar.MONTH) + 1));
                String day = c.get(Calendar.DAY_OF_MONTH) > 9 ? String.valueOf(c.get(Calendar.DAY_OF_MONTH)) : ("0" + (c.get(Calendar.DAY_OF_MONTH)));
                String weekDate = c.get(Calendar.YEAR) + "-" + month + "-"
                        + day;

                holidayAndWeekSet.add(weekDate);
            }

            // 日期+1
            c.add(Calendar.DATE, 1);

        }

        // 2. 添加节假日和删除补班信息
        // 2.1. 调用OpenAPI 获取假期信息
        String result = HttpUtil.get("https://timor.tech/api/holiday/year/" + year);

        JSONObject holidayInfos = null;
        if (result != null) {
            JSONObject jsonObject = JSONUtil.parseObj(result);
            if (0 == ((Integer)jsonObject.get("code"))) {
                holidayInfos = (JSONObject) jsonObject.get("holiday");
            }
        }

        // 2.2. 添加或剔除信息
        if (CollUtil.isNotEmpty(holidayInfos)) {
            holidayInfos.forEach((key, value) -> {
                JSONObject dateMap = (JSONObject) value;
                String holidayDate = (String) dateMap.get("date");
                Boolean holiday = (Boolean) dateMap.get("holiday");
                if (holiday) {
                    holidayAndWeekSet.add(holidayDate);
                } else {
                    holidayAndWeekSet.remove(holidayDate);
                }
            });
        }
        holidayAndWeekSet.forEach(date -> System.out.println(StrUtil.format(template, date)));
    }
}
