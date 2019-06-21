
import java.util.Random;
public class DiningPhilosopher
{

    public static void main(String[] args)
    {
        Sticks st=new Sticks();
        Philosopher p1=new Philosopher("1",st);
        Philosopher p2=new Philosopher("2",st);
        Philosopher p3=new Philosopher("3",st);
        Philosopher p4=new Philosopher("4",st);
        Philosopher p5=new Philosopher("5",st);
        p1.start();

        p2.start();
        p3.start();
        p4.start();
        p5.start();


    }

}

class Sticks
{
    private static int no=5;
     public boolean getSticks()
    {
        while(no<2);
            synchronized(this)
            {
                no=no-2;
                return true;
            }

    }
    synchronized public void returnSticks()
    {
            no=no+2;

    }
    public int getCount()
    {
        return no;
    }


}

class Philosopher extends Thread
{
    Random random = new Random();
    Sticks st;
    String name;
    Philosopher(String name,Sticks st)
    {
        this.name=name;
        this.st=st;
    }
    public void run()
    {

        while(true)
        {



                System.out.println("this is "+name+" "+" is looking at "+st.getCount()+" count ");
              /*do
                {
                    System.out.println("I "+name+" waiting");
                }*/
                st.getSticks();
                System.out.println("this is "+name+" "+" is looking at "+st.getCount()+" count after taking");
                try
                {
                    this.sleep(random.nextInt(100));
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }

                st.returnSticks();

                System.out.println("this is "+name+" "+" is looking at "+st.getCount()+" count after returning");
                try
                {
                    this.sleep(random.nextInt(100));
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
        }
    }


}
