public class SleeperBasic {
    public void runWithDelay(Runnable runable, long time){
        try{
            Thread.sleep(time);
            runable.run();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("metodo interrumpido");
        }
    }
}
