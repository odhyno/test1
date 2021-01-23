package entity;

/**
 *  Entità relativa ai parametri di configurazione
 *  @author Beccarini Luca, Ludovisi Linda, Paci Andrea
 *  @version 1.0
 */
public class Parameter
{
    private String name;
    private double val;

    public Parameter(String name, double val)
    {
        this.name = name;
        this.val = val;
    }


    public void setName(String name) { this.name = name; }

    public void setVal(double val) { this.val = val; }

    public String getName() { return name; }

    public double getVal() { return val; }
}
