package ClassFile;
class MenuInfo{
	private String menuname;
	private int menuid;
	private double menuprice;
	public MenuInfo(int menuid,String menuname,double menuprice){
		this.menuid=menuid;
		this.menuname=menuname;
		this.menuprice=menuprice;
	}
	public void setMenuID(int menuid){
		this.menuid=menuid;
	}
	public int getMenuID(){
		return this.menuid;
	}
	public void setMenuName(String menuname){
		this.menuname=menuname;
	}
	public String getMenuName(){
		return this.menuname;
	}
	public void setMenuPrice(double menuprice){
		this.menuprice=menuprice;
	}
	public double getMenuPrice(){
		return this.menuprice;
	}
}