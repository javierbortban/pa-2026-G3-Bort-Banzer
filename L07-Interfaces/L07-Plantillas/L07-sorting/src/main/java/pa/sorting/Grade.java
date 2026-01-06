package pa.sorting;

import pa.Interfaces.IOrdenable;

public class Grade implements IOrdenable {
    private double value;

    public Grade(double grade) {
        value = grade;
    }
    
    public double getValue() {
        return value;
    }

	@Override
	public boolean menorQue(IOrdenable o) {
		Grade grado=(Grade) o;
		return this.value < grado.value;
	}
}
