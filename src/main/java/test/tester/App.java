package test.tester;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.json.JSONObject;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.data.mapping.PropertyPath;
import org.springframework.util.NumberUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	App app = new App();
    	app.others();
//    	app.pivot();
//    	app.referencialStorage();
//    	app.optional();
//    	streamsParallel(1000);
//    	streamsParallel(1001);
//    	streamsParallel(1002);
//    	streamsParallel(1003);
//    	streamsParallel(1004);
//    	app.integers();
//    	app.exceptional();
    	
//    	nullcheck();
    	//floatCheck();
    	//exchange();
    	//others();
    	//setsAndString();
    	//typeCheck();
    	//dateTimeparser();
    	//mapAndEntry();
    	//maps();
    	//optional();
//    	regex();
//    	System.out.println(MockData.getData().size());
//    	System.out.println(ExchangeData.getData().size());
//    	System.out.println();
//    	System.out.println(MockData.getData().stream().map(i->i.getMorningstarCode()).distinct().count());
//    	System.out.println(ExchangeData.getData().stream().map(i->i.getMorningstarCode()).distinct().count());
//    	System.out.println();
//    	
//    	System.out.println("duplicates");
//    	Set<String> allItems = new HashSet<>();
//    	Set<String> duplicates = MockData.getData().stream().map(i->i.getMorningstarCode())
//    	        .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
//    	        .collect(Collectors.toSet());
//    	System.out.println(duplicates);
//    	
//    	System.out.println();
//    	System.out.println("GLOBAL");
//    	System.out.println(MockData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("GLOBAL")).map(i->i.getMorningstarCode()).distinct().count());
//    	List<String> s = MockData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("GLOBAL")).map(i->i.getMorningstarCode()).collect(Collectors.toList());
//    	
//    	System.out.println(ExchangeData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("GLOBAL")).map(i->i.getMorningstarCode()).filter(i -> !s.contains(i)).peek(i-> System.out.println(i)).count());
//    	System.out.println("US");
//    	System.out.println(MockData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("US")).map(i->i.getMorningstarCode()).distinct().count());
//    	System.out.println(ExchangeData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("US")).map(i->i.getMorningstarCode()).distinct().count());
//    	System.out.println("EXUS");
//    	System.out.println(MockData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("EXUS")).map(i->i.getMorningstarCode()).distinct().count());
//    	System.out.println(ExchangeData.getData().stream().filter(i->i.getUniverseExchangeEligibility().get("EXUS")).map(i->i.getMorningstarCode()).distinct().count());
//    	System.out.println();
//    	System.out.println(MockData
//        		.getData()
//        		.stream()
//        		.filter(j-> ExchangeData.getData().stream().noneMatch(i -> i.getMorningstarCode().equals(j.getMorningstarCode()) && i.getIsoOperating().equals(j.getIsoOperating()) && i.getIsoSegment().equals(j.getIsoSegment())))
//        		//.peek(k->System.out.println(k.getMorningstarCode()))
//        		.count()
//        	);
//    	
//    	System.out.println(MockData
//    		.getData()
//    		.stream()
//    		.filter(j-> ExchangeData.getData().stream().map(i -> i.getMorningstarCode()).noneMatch(i -> i.equals(j.getMorningstarCode())))
//    		//.peek(k->System.out.println(k.getMorningstarCode()))
//    		.count()
//    	);
//    	
//    	System.out.println(ExchangeData
//        		.getData()
//        		.stream()
//        		.filter(j-> MockData.getData().stream().map(i -> i.getMorningstarCode()).noneMatch(i -> i.equals(j.getMorningstarCode())))
//        		.peek(k->System.out.println(k.getMorningstarCode()))
//        		.count()
//        	);
////    		.forEach(i -> ExchangeData.getData().forEach(j-> {
////    			if(j.getMorningstarCode().equals(i.getMorningstarCode()))
////    		})
    	
//    	List<String> ss= Arrays.asList("a","b","c");
    	
    	//mapAndEntry();
    }
    private void pivot() {
    	List<Integer> list = List.of(5,6,7,8,9,1,2,3,4);
    	Integer result = findPivot(list, 0, list.size());
    	System.out.println("list:"+list+" | result: "+result);
    }
    
    private Integer findPivot(List<Integer> list, Integer start, Integer end) {
    	if(list.size()==1) {
    		return -1;
    	}
    	if(start+1==end) {
    		return start;
    	}
    	Integer mid = (end+start)/2;
    	if(list.get(mid) >= list.get(end-1)) {
    		return findPivot(list, mid, end);
    	}
    	else {
    		return findPivot(list, start, mid);
    	}
    }
    
    private void fields() throws Exception {
    	MMDTV data = new MMDTV();
    	ExchangeConfig config = new ExchangeConfig();
    	config.setIsoOperating("yeah, yo");
    	data.setEconfig(List.of(config));
//    	System.out.println(data.getEconfig().get(0).getIsoOperating());
//    	
//    	Field field = ExchangeConfig.class.getDeclaredField("isoOperating");
//    	System.out.println(field);
//    	
//    	field.setAccessible(true);
//    	
//    	Class c1 = field.getDeclaringClass();
//        while (c1 != null) {
//            System.out.println(c1.getName());
//            c1 = c1.getSuperclass();
//        }
        
        System.out.println(PropertyUtils.getNestedProperty(data.getEconfig().get(0), "isoOperating"));
        System.out.println(PropertyUtils.getPropertyDescriptor(data.getEconfig().get(0), "isoOperating").getDisplayName());
        
        System.out.println(BeanUtils.describe(data));
        
        System.out.println(PropertyAccessorUtils.canonicalPropertyName("isoOperating"));
        
        PropertyPath path = PropertyPath.from("econfig", MMDTV.class);
        System.out.println(path);
        org.hibernate.loader.PropertyPath p = new org.hibernate.loader.PropertyPath("econfig");
        System.out.println(p.getFullPath());
        
    }
    
    private void jsonpath() throws Exception {
    	
    	String json = "{\r\n"
    			+ "    \"store\": {\r\n"
    			+ "        \"book\": [\r\n"
    			+ "            {\r\n"
    			+ "                \"category\": \"reference\",\r\n"
    			+ "                \"author\": \"Nigel Rees\",\r\n"
    			+ "                \"title\": \"Sayings of the Century\",\r\n"
    			+ "                \"price\": 8.95\r\n"
    			+ "            },\r\n"
    			+ "            {\r\n"
    			+ "                \"category\": \"fiction\",\r\n"
    			+ "                \"author\": \"Evelyn Waugh\",\r\n"
    			+ "                \"title\": \"Sword of Honour\",\r\n"
    			+ "                \"price\": 12.99\r\n"
    			+ "            },\r\n"
    			+ "            {\r\n"
    			+ "                \"category\": \"fiction\",\r\n"
    			+ "                \"author\": \"Herman Melville\",\r\n"
    			+ "                \"title\": \"Moby Dick\",\r\n"
    			+ "                \"isbn\": \"0-553-21311-3\",\r\n"
    			+ "                \"price\": 8.99\r\n"
    			+ "            },\r\n"
    			+ "            {\r\n"
    			+ "                \"category\": \"fiction\",\r\n"
    			+ "                \"author\": \"J. R. R. Tolkien\",\r\n"
    			+ "                \"title\": \"The Lord of the Rings\",\r\n"
    			+ "                \"isbn\": \"0-395-19395-8\",\r\n"
    			+ "                \"price\": 22.99\r\n"
    			+ "            }\r\n"
    			+ "        ],\r\n"
    			+ "        \"bicycle\": {\r\n"
    			+ "            \"color\": \"red\",\r\n"
    			+ "            \"price\": 19.95\r\n"
    			+ "        }\r\n"
    			+ "    },\r\n"
    			+ "    \"expensive\": 10\r\n"
    			+ "}";
    	
    	Configuration conf = Configuration.builder()
    			   .options(Option.AS_PATH_LIST).build();
    	List<String> pathList = JsonPath.using(conf).parse(json).read("$..isbn");
    	
    	System.out.println(pathList);
    	
    }
    
    private void bigdecimals() {
    	System.out.println(new BigDecimal("0.695555468314558"));
    	System.out.println(new BigDecimal("0.7"));
    	System.out.println(new BigDecimal("0.7").compareTo(new BigDecimal("0.695555468314558")));
    	System.out.println(new BigDecimal("0.7").compareTo(BigDecimal.valueOf(0.695555468314558)));
    	System.out.println(new BigDecimal("0.7").compareTo(new BigDecimal("0.795555468314558")));
    }
    
    private void referencialStorage() {
    	List<ExchangeConfig> configs = List.of(1,2,3)
    		.stream()
    		.parallel()
    		.map(i -> {
    			ExchangeConfig e = new ExchangeConfig();
    			e.setExchangeCountryIso2(String.valueOf(i));
    			return e;
    		})
    		.collect(Collectors.toList());
//    	configs.stream().forEach(i-> {System.out.println(i.getExchangeCountryIso2());});
    	referencialStorageHelper(configs);
    	configs.stream().forEach(i-> {System.out.println(i.getExchangeCountryIso2());});
    }
    
    private void referencialStorageHelper(List<ExchangeConfig> configs) {
    	configs.get(0).setExchangeCountryIso2("100");
    }
    
    private void integers() {
    	System.out.println(Integer.parseInt("1"));
    	// these fail
//    	System.out.println(Integer.parseInt("1.0"));
//    	System.out.println(Integer.parseInt(""));
//    	System.out.println(Integer.parseInt(null));
    }
    
    private void exceptional() {
    	try {
    		System.out.println("try");
    	}
    	catch(Exception e) {
    		System.out.println("catch");
    	}
    	finally {
    		System.out.println("finally");
    	}
    	
    	try {
    		System.out.println("try");
    	}
    	catch(Exception e) {
    		System.out.println("catch");
    		throw new RuntimeException("");
    	}
    	finally {
    		System.out.println("finally");
    	}
    	
    	try {
    		System.out.println("try");
    		throw new RuntimeException("");
    	}
    	catch(Exception e) {
    		System.out.println("catch");
    	}
    	finally {
    		System.out.println("finally");
    	}
    	
    	try {
    		System.out.println("try1");
    		throw new RuntimeException("");
    	}
    	catch(Exception e) {
    		System.out.println("catch1");
    		throw new RuntimeException("");
    	}
    	finally {
    		System.out.println("finally1");
    	}
    }
    
    private void datetime() {
    	LocalDate now = LocalDate.of(2021, 4, 30);
    	System.out.println(now);
    	System.out.println(now.with(TemporalAdjusters.firstDayOfNextMonth()));
    	System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));
    	System.out.println(now.minusMonths(6));
    	System.out.println(now.minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()));
    	System.out.println(now.minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek());
    	System.out.println(now.minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek().equals(DayOfWeek.SATURDAY));
    	System.out.println(now.minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek().equals(DayOfWeek.SATURDAY) ? now.minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()).minusDays(1): now.minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()));
    }
    
    private void functional() {
////    	List<MMDTV> mmdtvList = Arrays.asList();
////    	mmdtvList = sorting(mmdtvList, Comparator.comparing(MMDTV::getM1));
////    	mmdtvList = ranking(mmdtvList, MMDTV::getM1, MMDTV::setM1);
	}
    
//    private List<MMDTV> sorting(List<MMDTV> mmdtvList, Comparator<MMDTV> getter) {
//    	Collections.sort(mmdtvList, getter);
//    	return mmdtvList;
//    }
    private <T> List<T> sorting(List<T> mmdtvList, Comparator<T> getter) {
    	Collections.sort(mmdtvList, getter);
    	return mmdtvList;
    }
    
    private <T, P> List<T> ranking(List<T> mmdtvList, Function<T, P> getter, BiConsumer<T, P> setter) {
    	return mmdtvList;
    }

    private static void streamsParallel(int stop) {
    	long messageStart = System.currentTimeMillis();
    	IntStream.rangeClosed(1, stop)
    		    .boxed().parallel().forEach( i -> { i = (int) (i/Math.random()); });
    	long messageStop = System.currentTimeMillis();
    	System.out.println("streamsParallel");
    	System.out.println(messageStop - messageStart);
    }
    
    private static void streams() {
    	long messageStart = System.currentTimeMillis();
    	IntStream.rangeClosed(1, 1000)
    		    .boxed().forEach( i -> { i = (int) (i/Math.random()); });
    	long messageStop = System.currentTimeMillis();
    	System.out.println("streams");
    	System.out.println(messageStop - messageStart);
    }
    
    private static void nullcheck() {
    	ExchangeConfig ob = MockData.getData().get(0);
    	System.out.println(ob==null);
    	System.out.println(ob.equals(null)); //bad practice - don't compare dissimilar types
    	System.out.println(Optional.ofNullable(ob).isPresent());
    	System.out.println(Objects.isNull(ob));
    	System.out.println(ob!=null);
    	System.out.println(!ob.equals(null));//bad practice
    	System.out.println();
    	
    	ExchangeConfig another = ob;
    	System.out.println(another==null);
    	System.out.println(!another.equals(null));//bad practice
    	System.out.println(Optional.ofNullable(another).isPresent());
    	System.out.println(Objects.isNull(another));
    	System.out.println(another!=null);
    	System.out.println(another.equals(null)); //bad practice - don't compare dissimilar types
    	System.out.println();
    	
    	another = null;
    	System.out.println(another==null);
    	System.out.println(another!=null);
    	System.out.println("-");//System.out.println(another.equals(null)); //bad practice - don't compare dissimilar types
    	System.out.println("-");//System.out.println(!another.equals(null));//bad practice
    	System.out.println(Optional.ofNullable(another).isPresent());
    	System.out.println(Objects.isNull(another));
    	System.out.println();
    	
    	System.out.println(ob==null);
    	System.out.println(ob!=null);
    	System.out.println(ob.equals(null)); //bad practice - don't compare dissimilar types
    	System.out.println(!ob.equals(null));//bad practice
    	System.out.println(Optional.ofNullable(ob).isPresent());
    	System.out.println(Objects.isNull(ob));
    	System.out.println();
    }
    
    private static void floatCheck() {
    	System.out.println(Float.parseFloat("1.0"));
    	System.out.println(Float.parseFloat("2"));
    }
    private static void regex() {
    	System.out.println(Pattern.compile(".").matcher("a").matches());  
    }
    
    private static void maps() {
    	System.out.println("maps");
    	Map<String, String> map = Map.of("firstname", "dhananjay","lastname", "gupta");
    	System.out.println(map.get("firstname"));
    	System.out.println(map.get("firstnam"));
    }
    
    private static void exchange() {
    	System.out.println(MockData.getData().get(0).toString());
    	System.out.println(MockData.getData().get(0).toString("GLOBAL"));
    }
    
    private static void mapAndEntry() {
    	Entry<Integer, Integer> m = Map.entry(1, 2);
    	System.out.println(m);
    	Entry<Integer, Integer> m1 = null;
    	System.out.println(m1);
    	m1 = Map.entry(3, 4);
    	System.out.println(m1);
    	Entry<Integer, Integer> m2 = Map.entry(5, 6);
    	System.out.println(m2);
    	m2 = Map.entry(7, 8);
    	System.out.println(m2);
    	
    	 Gson gson = new Gson();
    	 
    	 Entry<Integer, Double> m3 = Map.entry(1, 2.0);
    	 String mapEntryJson =  gson.toJson(m3);
    	 
    	 System.out.println();
     	 System.out.println(m3);
    	 System.out.println(mapEntryJson);
    	 System.out.println(m3.toString());
    	 System.out.println(gson.toJson(m3, new TypeToken<Entry<Integer, Double>>(){}.getType()));
    	 System.out.println(gson.toJson(Map.ofEntries(m3)));
    }
    
    public static void optional() {
    	
    	String s = "this is a string";
    	System.out.println(s);
    	System.out.println(Optional.of(s));
    	
    	s= null;
    	System.out.println(s);
    	// throws null pointer
    	//System.out.println(Optional.of(s));
    	
    	Optional<String> opt = Optional.ofNullable(s);
    	System.out.println(opt);
    	System.out.println(opt.isPresent());
    	System.out.println(opt.isEmpty());
    	// exception thrown
    	//System.out.println(opt.get());
    	
    	s = "This is string again";
    	System.out.println(s);
    	
    	opt = Optional.ofNullable(s);
    	System.out.println(opt);
    	System.out.println(opt.isPresent());
    	System.out.println(opt.isEmpty());
    	System.out.println(opt.get());
    }
    
    public static void dateTimeparser() {
    	DateTimeFormatter parser = new DateTimeFormatterBuilder()
    		    .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
    		    .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"))
    		    .appendOptional( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"))
    		    .appendOptional( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.S"))
    		    .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    		    .appendOptional(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    		    .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))
    		    .toFormatter();
    	System.out.println(LocalDateTime.parse("2019-02-02T23:55:12.3", parser));
    	System.out.println(LocalDateTime.parse("2019-02-04 23:55:12.333", parser));
    	System.out.println(LocalDateTime.parse("2019-02-02 23:55:12.3", parser));
    	System.out.println(LocalDateTime.parse("2019-02-02T22:05"));
    	System.out.println(LocalDateTime.parse("2019-06-19T01:00:40", parser));
    	
    	//joda
    	DateTime datetime = DateTime.now();
    	System.out.println(datetime);
    	System.out.println(datetime.toLocalDateTime());
    	System.out.println(LocalDateTime.parse(datetime.toLocalDateTime().toString()));
    }
    
    public static void doubleCheck() {
    	Double a = 1.0;
    	System.out.println(a);
    	System.out.println(a.toString());
    	System.out.println(Double.parseDouble(a.toString()));
    }
    
    public static void typeCheck() {
    	System.out.println("haha");
    	int test = 0;
    	if(test==0 || 0 == ++test ) {
    		System.out.println(test);
    	}
    	if(0 == ++test  || test==1) {
    		System.out.println(test);
    	}
    	System.out.println("haha");
    }
    public static void setsAndString() {
    	Set<String> test = new HashSet<>(Arrays.asList("I1", "I2"));
    	System.out.println(test);
    	System.out.println(test.stream().map(i->i).collect(Collectors.toList()));
    	System.out.println(test.toString().split(",")[0]);
    	System.out.println(Arrays.asList("I1", "I2"));    	
    	System.out.println(Arrays.stream(test.toString().replace("'", "").replace("[", "").replace("]", "").split(",")).map(i->i.trim()).collect(Collectors.toSet()));
    }
    
    public static void stringActions() {
    	String s = "[\"PREFEQ\",\"SHARE\",\"UNIT\",\"ADR\"]";
    	System.out.println(s);
    	Stream.of(s.replaceAll("[\\[\"\\]]",  "").split(",")).forEach(i->System.out.println(i));
    	System.out.println(s.replaceAll("[\\[\"\\]]",  "").split(",").length);
    	Arrays.stream(s.replaceAll("[\\[\"\\]]",  "").split(",")).forEach(i->System.out.println(i));
    }
    
    
    public static void getTasks(){
		String stringToParse = "{\"data\":{\"name\":\"New Product\",\"id\":1,\"description\":\"\",\"is_active\":true,\"parent\":{\"id\":0,\"name\":\"All Projects\"}}}";
		JSONObject jsonObject = new JSONObject(stringToParse);
		System.out.println(jsonObject.get("data"));
		JSONObject a = (JSONObject) jsonObject.get("data");
		System.out.println(a.get("parent"));
		JSONObject b = (JSONObject) a.get("parent");
		System.out.println(b.get("id"));
	}
    
    public static void others() {
    	System.out.println( "Hello World!" );
        String s = "[HK=0.4,CN=0.6,ns=0.0]";
//        Map<String, String> mapped = Arrays.stream(s.replace("'", "").replace("[", "").replace("]", "").split(","))
//						            	.map(i -> i.split("="))
//						            	.collect(Collectors.toMap(i->i[0], i->i[1]));
						        
//        System.out.println(mapped);
//        System.out.println(mapped.get("ns"));
        
        System.out.println(Boolean.valueOf("1"));
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf(null));
        
        long date = 0L;
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").withZone(ZoneId.of("UTC")).format(Instant.ofEpochMilli(date)));
        int i= 1000000000;
        System.out.println(i);
        System.out.println((long)i);
        
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().toString());
        System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.parse("2019-01-01T00:00:01"));
        System.out.println(LocalDate.parse("2019-01-01"));
        System.out.println(Date.valueOf(LocalDate.parse("2019-12-12")));
        System.out.println(Date.valueOf("2019-01-01"));
        System.out.println(java.util.Date.from(Instant.now()));
        System.out.println(LocalDateTime.parse("2021-01-01T00:00:01").toInstant(ZoneOffset.UTC));
        System.out.println(java.util.Date.from(LocalDateTime.parse("2021-01-01T00:00:01").toInstant(ZoneOffset.UTC)));
        
        
        System.out.println(LocalDateTime.parse(LocalDateTime.MAX.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        String a = "ssss";
        String b = null;
        System.out.println(a+" "+b);
        Map<String, Map<String, Integer> > universes = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("inner", 1);
        universes.put("outer", map);
        System.out.println(universes);
        
        System.out.println(java.time.temporal.ChronoUnit.DAYS.between(LocalDate.of(2020, 4, 28), LocalDate.of(2020, 4, 30)));
        System.out.println(java.time.temporal.ChronoUnit.DAYS.between(LocalDate.of(2020, 4, 28), LocalDate.of(2020, 4, 30))+1);
        System.out.println(java.time.temporal.ChronoUnit.DAYS.between(LocalDate.of(2020, 4, 30), LocalDate.of(2020, 4, 30)));
        System.out.println(java.time.temporal.ChronoUnit.DAYS.between(LocalDate.of(2020, 4, 30), LocalDate.of(2020, 4, 30))+1);
    }
}
