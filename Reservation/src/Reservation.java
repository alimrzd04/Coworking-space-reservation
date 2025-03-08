public class Reservation {
   private int reservId;
   private String name;
   private String date;
   private String startTime;
   private String endTime;

   public Reservation(int reservId , String name, String date , String startTime,String endTime){
       this.reservId = reservId;
       this.name = name;
       this.date = date;
       this.startTime = startTime;
       this.endTime = endTime;
   }

    public Integer getReservId(){
        return reservId;}
    public String getName(){
        return name;}
    public String getDate(){
        return date;}
    public String getStartTime(){
        return startTime;}
    public String getEndTime(){
        return endTime;}

}
