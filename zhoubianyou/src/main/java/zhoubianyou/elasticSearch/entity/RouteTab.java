package zhoubianyou.elasticSearch.entity;

import java.util.Date;

/**
 * ±Í«©
 * 
 * @author Administrator
 *
 */
public class RouteTab {
	private String tab_name;
	private Date tab_createdate;

	private int tab_sequence;

	private String tab_color;

	
	public RouteTab(){
		
	}
	public RouteTab(String tabName,int sequence,String color){
		this.tab_color= color;
		this.tab_createdate=new Date();
		this.tab_sequence = sequence;
		this.tab_name = tabName;
		
	}
	public String getTab_name() {
		return tab_name;
	}

	public void setTab_name(String tab_name) {
		this.tab_name = tab_name;
	}


	public Date getTab_createdate() {
		return tab_createdate;
	}
	public void setTab_createdate(Date tab_createdate) {
		this.tab_createdate = tab_createdate;
	}


	public int getTab_sequence() {
		return tab_sequence;
	}
	public void setTab_sequence(int tab_sequence) {
		this.tab_sequence = tab_sequence;
	}
	public String getTab_color() {
		return tab_color;
	}

	public void setTab_color(String tab_color) {
		this.tab_color = tab_color;
	}
	
	

}
