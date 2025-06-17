
public class Domicili {
    private String carrer;
    private int cp;
    private String poble;


    public Domicili(String carrer, int cp, String poble) {
        this.carrer = carrer;
        this.cp = cp;
        this.poble = poble;
    }

    public Domicili() {  
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getCp() {  
      return cp;
    }

    public String getPoble() {
        return poble;
    }

    public void setCp(int cp){
        this.cp=cp;
    }

    public void setPoble(String poble) {
        this.poble = poble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Domicili{");
        sb.append("carrer=").append(carrer);
        sb.append(", cp=").append(cp);
        sb.append(", poble=").append(poble);
        sb.append('}');
        return sb.toString();
      

    }

    
    
}
