package CreationalDP.Builder;

/**
 * Created by shalvi on 19/03/16.
 */
public class LunchOrderBuilder {

    private String bread;
    private String meat;
    private String condiment;
    private String dressing;

    public static class Builder{
        private String bread;
        private String meat;
        private String condiment;
        private String dressing;

        public Builder(){

        }
        public LunchOrderBuilder build(){
            return new LunchOrderBuilder(this);
        }

        public Builder bread(String bread){
            this.bread = bread;
            return this;
        }

        public Builder meat(String meat){
            this.meat = meat;
            return this;
        }

        public Builder condiment(String condiment){
            this.condiment = condiment;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing = dressing;
            return this;
        }
    }

    public LunchOrderBuilder(Builder builder){
        this.bread = builder.bread;
        this.condiment = builder.condiment;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public String getCondiment() {
        return condiment;
    }

    public String getDressing() {
        return dressing;
    }

}
