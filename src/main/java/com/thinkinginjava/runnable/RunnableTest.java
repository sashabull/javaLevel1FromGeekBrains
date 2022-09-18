package com.thinkinginjava.runnable;

/**
 * изучение работы интерфейса Runnable
 */
public class RunnableTest implements Runnable {
    protected           int     countDown   = 11 ;          // визуализация работы экземпляра
    private     static  int     taskCount   = 0;            // количество экземпляров класса
    private     final   int     id          = taskCount++ ; // id (номер) экземпляра

    /**
     * constructors
     */
    public RunnableTest(){}
    public RunnableTest( int countDown ){
        this.countDown = countDown;
    }

    /**
     * вывод id и инфу о потоке
     * @return - id задачи и инфу о потоке
     */
    public String status(){
        return "поток #" + id + ", работа потока (" +
                ( countDown > 0 ? countDown : "RunnableTest (стоп поток)!") + "), ";
    }

    /**
     * определяем в поток в работающем процессе-задаче
     */
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            Thread.yield();                 //  уступаем процессор следующему потоку если предыдущий встал или завершился
        }
    }
}
