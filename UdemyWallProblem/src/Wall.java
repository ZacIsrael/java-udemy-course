public class Wall {

    private double width;
    private double height;

    public Wall(){

        this.width = width;
        this.height = height;
    }
    public void Wall(double width, double height){
        if(height < 0){
            this.height = 0;
        }
        if(width == 0){
            this.width = 0;
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void getArea(){

    }
}
