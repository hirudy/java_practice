package org.zhangyoubao.httpServer.lib;


import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具
 * @author cuicorey
 *
 */
public class StringUtil {
	/**
	 * 字符串转化为long类型
	 * @param text 字符串
	 * @param defaultValue 解析失败的默认值
	 * @return long类型
	 */
	public static long convertLong(String text,long defaultValue)
	{
		try {
			return Long.parseLong(text);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
	
	public static String trim(String text){
		if(text==null)
		{
			return "";
		}
		return text.trim();
	}
	/**
	 * 全局替换
	 * @param s 字符串
	 * @param src 需要被替换的字符串 
	 * @param dest 需要替换的目标字符串
	 * @return 被替换后的字符串
	 */
	public static String replaceAll(String s, String src, String dest)
    {
    	if(s == null || src == null || dest == null || src.length() == 0)
    		return s;
    	int pos = s.indexOf(src);			// 查找第一个替换的位置
    	if(pos < 0)
    		return s;
    	int capacity = dest.length() > src.length() ? s.length() * 2: s.length();
    	StringBuilder sb = new StringBuilder(capacity);
    	int writen = 0;
    	for(; pos >= 0; )
    	{
    		sb.append(s, writen, pos);		// append 原字符串不需替换部分
    		sb.append(dest);				// append 新字符串
    		writen = pos + src.length();	// 忽略原字符串需要替换部分
    		pos = s.indexOf(src, writen);	// 查找下一个替换位置
    	}
    	sb.append(s, writen, s.length());	// 替换剩下的原字符串
    	return sb.toString();
    }
	
	/**
	 * 将字符串分隔为int列表
	 * @param text 字符串
	 * @param length int列表长度
	 * @param dem 分隔符
	 * @return int列表
	 * @throws Exception 无法解析的时候抛出
	 */
	public static int[] splitToInt(String text,int length,String dem) throws Exception
	{
		if(text==null)
		{
			return new int[0];
		}
		int[] fields=new int[length];
		StringTokenizer st = new StringTokenizer(text,dem);
		for(int i=0;i<length;i++)
		{
			if(st.hasMoreElements())
			{
				int value = Integer.parseInt( st.nextToken());
				fields[i] = value;
			}
			else
			{
				fields[i] = 0;
			}
		}
		return fields;
	}
	
	/**
	 * 将字符串分隔为int列表
	 * @param text 字符串
	 * @param dem 分隔符
	 * @return int列表
	 * @throws Exception 无法解析的时候抛出
	 */
	public static int[] splitToInt(String text,String dem) throws Exception
	{
		if(text==null)
		{
			return new int[0];
		}
		StringTokenizer st = new StringTokenizer(text,dem);
		int[] fields=new int[st.countTokens()];
		for(int i=0;i<fields.length;i++)
		{
			int value = Integer.parseInt( st.nextToken());
			fields[i] = value;
		}
		return fields;
	}
	
	/**
	 * 将字符串分隔为字符串列表
	 * @param text 字符串
	 * @param dem 分隔符
	 * @return 字符串列表
	 */
	public static String[] split(String text,String dem)
	{
		if(text==null)
		{
			return new String[0];
		}
		StringTokenizer st = new StringTokenizer(text,dem);
		String[] fields=new String[st.countTokens()];
		for(int i=0;i<fields.length;i++)
		{
			fields[i] = st.nextToken();
		}
		return fields;
	}
	
	/**
	 * 将字符串分隔为字符串列表
	 * @param text 字符串 
	 * @param length 分隔成的字符串长度
	 * @param dem 分隔符
	 * @return 字符串列表
	 */
	public static String[] split(String text,int length,String dem)
	{
		if(text == null)
		{
			return null;
		}
		String[] fields=new String[length];
		StringTokenizer st = new StringTokenizer(text,dem);
		for(int i=0;i<length;i++)
		{
			if(st.hasMoreElements())
			{
				fields[i] = st.nextToken();
			}
			else
			{
				fields[i] = "";
			}
		}
		return fields;
	}
	
	
	/**
	 * 将字符串转化为int类型
	 * @param text 字符串
	 * @param defaultValue 默认值
	 * @return int类型
	 */
	public static int convertInt(String text,int defaultValue)
	{
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
	
	
	public static boolean convertBoolean(String text,boolean defaultValue)
	{
		if(StringUtil.isEmpty(text)){
			return defaultValue;
		}
		if("true".equalsIgnoreCase(text.trim())){
			return true;
		}
		if("false".equalsIgnoreCase(text.trim())){
			return false;
		}
		int numerial = StringUtil.convertInt(text, -1);
		if(numerial>0){
			return true;
		}else if(numerial==0){
			return false;
		}
		return defaultValue;
	}
	
	/**
	 * 字符串是否为空
	 * @param text 字符串
 	 * @return true：为空 false：不为空
	 */
	public static boolean isEmpty(String text)
	{
		return text==null || text.length()==0;
	}
	
	/**
	 * 是否是数字
	 * @param c 字符
	 * @return	true：数字 false：不是数字
	 */
	public static boolean isDigit(char c)
	{
		if(c>='0' && c<='9')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isDigit(String s){
		if(isEmpty(s)){
			return false;
		}
		for(int i=0;i<s.length();i++){
			if(!isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 连接列表
	 * @param list 列表
	 * @param seperator 分隔符
	 * @return 字符串
	 */
	public static <E> String join(List<E> list,String seperator)
	{
		if(seperator == null)
		{
			seperator = ",";
		}
		StringBuffer sb=new StringBuffer();
		if(list != null && list.size() > 0)
		{
			Iterator<E> it = list.iterator();
			if(it.hasNext())
			{
				sb.append(it.next().toString());
			}
			while(it.hasNext())
			{
				sb.append(seperator).append(it.next().toString());
			}
		}
		else
		{
			return "";
		}
		return sb.toString();
	}
	
	
	/**
	 * 分隔http查询字符串
	 * @param query 查询
	 * @return Map<参数名称，参数值>
	 */
	public static Map<String,String> splitQueryString(String query) 
	{
		Map<String,String> queryPairMap = new HashMap<String,String>();
		String[] queryPairArray = StringUtil.split(query, "&");
		if(queryPairArray!=null && queryPairArray.length>0)
		{
			for(String queryPairStr : queryPairArray)
			{
				String[] queryPair = StringUtil.split(queryPairStr,2, "=");
				if(queryPair!=null && queryPair.length==2)
				{
					queryPairMap.put(queryPair[0], queryPair[1]);
				}
			}
		}
		return queryPairMap;
	}
	
	/**
	 * 是否是电话号码
	 * @param phone 被判断字符串
	 * @return  true：是电话号码 false：不是电话号码
	 */
	public static boolean isPhoneNum(String phone)
	{
		Pattern p = Pattern.compile("^1[34578]\\d{9}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	/**
	 * MD5加密
	 * @param src 需要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String md5(String src)
	{
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            byte[] btInput = src.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	/**
	 * 是否为空或者null
	 * @param src 需要判断的字符串
	 * @return true：为空 false：不为空
	 */
	public static boolean emptyOrNull(String src)
	{
		return (src == null || src.length() == 0);
	}
	

	public static String getCustomTimeString()
	{
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(now);
	}
	
	public static String getRandomNumberString(int length)
	{
		StringBuffer stringBuffer = new StringBuffer();
		Random random = new Random(System.currentTimeMillis());
		while (length-- > 0) {
			stringBuffer.append(Math.abs(random.nextInt()) % 10);
		}
		return stringBuffer.toString();
	}
	
	public static String getSalt()
	{
		int startIndex = Math.abs((new Random(10)).nextInt() % 10);
		return md5(System.currentTimeMillis() + "").substring(startIndex, startIndex + 12);
	}
	
	/**
	 * 是否是合法的昵称
	 * @param src 昵称
	 * @return true：合法 false：不合法
	 */
	public static boolean nicknameEnable(String src)
	{
		Pattern p = Pattern.compile("^[a-zA-Z0-9_\u4e00-\u9fa5]+$");
		Matcher m = p.matcher(src);
		return m.matches();
	}
	
	/**
	 * 过滤空字符串
	 * @param src 待处理字符串
	 * @return 处理以后的字符串
	 */
	public static String filterBlank(String src)
	{
		String dest = "";
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(src);
        dest = m.replaceAll("");
        return dest;
	}
	
	public static String replaceWithList(String src, List<String> hayStack, String stuff)
	{
		Iterator<String> iterator = hayStack.iterator();
		while (iterator.hasNext()) {
			String tmp = iterator.next();
			src = src.replaceAll(tmp, produceString("*", tmp.length()));
		}
		return src;
	}
	
	public static String produceString(String materials, int num)
	{
		StringBuffer stringBuffer = new StringBuffer();
		while (num -- > 0) {
			stringBuffer.append(materials);
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 是否是email
	 * @param email 需要判断的字符串
	 * @return true：是email false：不是email
	 */
	public static boolean isEmail(String email)
	{
		if (emptyOrNull(email)) return false;
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");  
        Matcher m = p.matcher(email);  
        return m.matches();  
	}
	
	/**
	 * 格式化时间
	 * @param mDate 时间
	 * @return  格式化后的字符串
	 */
	public static String formatTimestamp(java.sql.Timestamp mDate)
	{
		if (null == mDate)
		{
			return "1970-01-01 00:00:00";
		}
		try {
			String mText = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mDate);
			return mText;
		} catch (Exception e) {
			e.printStackTrace();
			return "1970-01-01 00:00:00";
		}
	}
	
	/**
	 * 格式化字符串
	 * @param str 字符串
	 * @param withHms 是否需要时分秒
	 * @return 格式化后的日期
	 */
	public static String format2DateStr(String str, boolean withHms)
	{
		String model = "yyyy-MM-dd HH:mm:ss";
		if (!withHms)
			model = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(model);
		Date date;
		try {
			date = sdf.parse(str);
			return sdf.format(date);
		} catch (ParseException e) {
		}
		if (!withHms)
			return "1970-01-01";
		return "1970-01-01 00:00:00";
	}
	
	public static boolean wildcardMatch(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
 
        boolean result = false;
        char c; // 当前要匹配的字符串
        boolean beforeStar = false; // 是否遇到通配符*
        int back_i = 0;// 回溯,当遇到通配符时,匹配不成功则回溯
        int back_j = 0;
        int i, j;
        for (i = 0, j = 0; i < str.length();) {
            if (pattern.length() <= j) {
                if (back_i != 0) {// 有通配符,但是匹配未成功,回溯
                    beforeStar = true;
                    i = back_i;
                    j = back_j;
                    back_i = 0;
                    back_j = 0;
                    continue;
                }
                break;
            }
 
            if ((c = pattern.charAt(j)) == '*') {
                if (j == pattern.length() - 1) {// 通配符已经在末尾,返回true
                    result = true;
                    break;
                }
                beforeStar = true;
                j++;
                continue;
            }
 
            if (beforeStar) {
                if (str.charAt(i) == c) {
                    beforeStar = false;
                    back_i = i + 1;
                    back_j = j;
                    j++;
                }
            } else {
                if (c != '?' && c != str.charAt(i)) {
                    result = false;
                    if (back_i != 0) {// 有通配符,但是匹配未成功,回溯
                        beforeStar = true;
                        i = back_i;
                        j = back_j;
                        back_i = 0;
                        back_j = 0;
                        continue;
                    }
                    break;
                }
                j++;
            }
            i++;
        }
 
        if (i == str.length() && j == pattern.length())// 全部遍历完毕
            result = true;
        return result;
    }
	
	
	public static void main(String[] args) {
        String userName = "''";
        String password = "123456";
        String sql = "SELECT COUNT(userId) FROM t_user WHERE userName='"
            + userName + "' AND password ='" + password + "'";
        System.out.println(sql);
        System.out.println(userName);
    }
}
