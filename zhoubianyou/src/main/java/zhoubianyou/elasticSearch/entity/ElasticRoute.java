package zhoubianyou.elasticSearch.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * æ∞µ„ µÃÂ
 * @author Administrator
 *
 */
public class ElasticRoute {
	
    private String route_id;
    private String title;
    private BigDecimal price;
    private Integer state;
    private Integer type;
    private Date createDate;
    private String descript;
    private BigDecimal suggest_price;
    private double score;
    private long order_count;
	private List<Map<String,Object>> tab;
    private String img_list;
    private String location;
    public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public BigDecimal getSuggest_price() {
		return suggest_price;
	}
	public void setSuggest_price(BigDecimal suggest_price) {
		this.suggest_price = suggest_price;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public long getOrder_count() {
		return order_count;
	}
	public void setOrder_count(long order_count) {
		this.order_count = order_count;
	}

	public List<Map<String, Object>> getTab() {
		return tab;
	}
	public void setTab(List<Map<String, Object>> tab) {
		this.tab = tab;
	}
	public String getImg_list() {
		return img_list;
	}
	public void setImg_list(String img_list) {
		this.img_list = img_list;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}



}
