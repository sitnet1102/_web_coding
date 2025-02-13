package _09_rentcar;

public class Rentcar {
	private int no;
	private String name;
	private int category;
	private int price;
	private int usepeople;
	private String company;
	private String img;
	private String info;
	public Rentcar(){}	
	public Rentcar(int no, String name, int category, int price, int usepeople, String company, String img,
			String info) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUsepeople() {
		return usepeople;
	}
	public void setUsepeople(int usepeople) {
		this.usepeople = usepeople;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
