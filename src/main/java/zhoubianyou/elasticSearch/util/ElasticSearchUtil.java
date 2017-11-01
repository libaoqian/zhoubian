package zhoubianyou.elasticSearch.util;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.junit.Test;

import zhoubianyou.elasticSearch.entity.ElasticRoute;
import zhoubianyou.elasticSearch.entity.RouteTab;

@SuppressWarnings("resource")
public class ElasticSearchUtil {

	private static TransportClient client = null;
	
	public ElasticSearchUtil(){
		try {
			if (client == null) {
				Settings settings = Settings.builder()
//						.put("client.transport.sniff", true)
						.put("cluster.name", "elasticsearch")
						.put("xpack.security.transport.ssl.enabled", false)
						.put("xpack.security.user", "elastic:changeme").build();
				client = new PreBuiltXPackTransportClient(settings)
						.addTransportAddress(new InetSocketTransportAddress(
								InetAddress.getByName("zhoubianyou.red"), 9300));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	static {
		try {
			if (client == null) {
				Settings settings = Settings.builder()
//						.put("client.transport.sniff", true)
						.put("cluster.name", "elasticsearch")
//						.put("xpack.security.transport.ssl.enabled", false)
						.put("xpack.security.user", "elastic:changeme").build();
				client = new PreBuiltXPackTransportClient(settings)
						.addTransportAddress(new InetSocketTransportAddress(
								InetAddress.getByName("zhoubianyou.red"), 9300));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static boolean bulkDocument(String type,Map<String,Object> map){
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		bulkRequest.add(client.prepareIndex("zhoubianyou",type).setSource(map));
		BulkResponse bulkResponse = bulkRequest.get();
		System.out.println(bulkResponse.hasFailures());
		if(bulkResponse.hasFailures()){

		}
		
		System.out.println(bulkResponse.buildFailureMessage());
		return !bulkResponse.hasFailures();
	}
	
	public static void deleteDocument(String type,String id){
		DeleteResponse response = client.prepareDelete("zhoubianyou",type,id).get();
		System.out.println(response.getResult().toString());
	}
	
	public static List<String> getSuggest(String str){
	
		Suggest
		
		return "";
		
	}
	
	
	@Test
	public void insert() {
		
		ElasticRoute route = new ElasticRoute();
		route.setRoute_id(UUID.randomUUID().toString());
		route.setCreateDate(new Date());
		route.setDescript("竹泉村");
		route.setLocation("35.64,118.43");
		route.setImg_list("http://wechat-1251350088.cossh.myqcloud.com/wechat/zqc.jpg");
		route.setOrder_count(10);
		route.setPrice(new BigDecimal(50));
		route.setScore(4.5);
		route.setState(0);
		route.setSuggest_price(new BigDecimal(98));
		route.setTitle("竹泉村旅游度假区");
		route.setType(0);
		
		RouteTab tab = new RouteTab("随买随用",0,"blue");
		RouteTab tab1 = new RouteTab("退款",1, "blue");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(beanToMap(tab));
		list.add(beanToMap(tab1));
		
		route.setTab(list);
		
		
		ElasticSearchUtil util = new ElasticSearchUtil();
		util.bulkDocument("route",beanToMap(route));
		
		

	}
	@Test
	public  void delete(){
		
		deleteDocument("route","AV92sl_9qhJOXR5nAQ0k");
	}
	


	//将javabean实体类转为map类型，然后返回一个map类型的值
	
    public static Map<String, Object> beanToMap(Object obj) { 
            Map<String, Object> params = new HashMap<String, Object>(0); 
            try { 
                PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
                PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
                for (int i = 0; i < descriptors.length; i++) { 
                    String name = descriptors[i].getName(); 
                    if (!"class".equals(name)) { 
                        params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                    } 
                } 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            return params; 
    }
    
    
}
