public class AbstractionMobile{
	public String Brand;
	public String Color;
	public String Price;
	protected String Discount;
	private String ImeiNum;
	protected String Name;
	protected String Specification;
	protected String Os;
	private String ModelNo;
	void AbstractionMobile(){
		
	}
	void AbstractionMobile(String Brand,String Color, String Price,String Discount){
		this.Brand=Brand;
		this.Color=Color;
		this.Price=Price;
		this.Discount=Discount;
	}
	
	void dispMob(){
		System.out.println("Brand name is " + Brand);
		System.out.println("Color is " + Color);
		System.out.println("Price " + Price);
		System.out.println("Mobile os is" + Os);
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getDiscount() {
		return Discount;
	}
	public void setDiscount(String discount) {
		Discount = discount;
	}
	public String getImeiNum() {
		return ImeiNum;
	}
	public void setImeiNum(String imeiNum) {
		ImeiNum = imeiNum;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	public String getOs() {
		return Os;
	}
	public void setOs(String os) {
		Os = os;
	}
	public String getModelNo() {
		return ModelNo;
	}
	public void setModelNo(String modelNo) {
		ModelNo = modelNo;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AbstractionMobile{");
        sb.append("Brand=").append(Brand);
        sb.append(", Color=").append(Color);
        sb.append(", Price=").append(Price);
        sb.append(", Discount=").append(Discount);
        sb.append(", ImeiNum=").append(ImeiNum);
        sb.append(", Name=").append(Name);
        sb.append(", Specification=").append(Specification);
        sb.append(", Os=").append(Os);
        sb.append(", ModelNo=").append(ModelNo);
        sb.append('}');
        return sb.toString();
    }
}