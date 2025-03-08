public class CoworkingSpaces {

    private int id;
    private String type;
    private double price;
    private boolean isAvailable;

    public CoworkingSpaces(int id, String type, double price, boolean isAvailable){
        this.id = id;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Integer getId(){
        return id;}
    public String getType(){
        return type;}
    public Double getPrice(){
        return price;}
    public boolean getIsAvailable(){
        return isAvailable;}

}
