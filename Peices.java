package yup;

public class Peices implements Cloneable {
	private char person;
	private boolean isUpgraded = false;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Peices(char person) {
		this.person = person;
	}

	public Peices(String whatIsIt) {
		if (whatIsIt.equals("Empty")) {
			person = 'E';
		} else {
			person = 'N';
		}
	}
	
	public char print() {
		return person;
	}

	public boolean isUpgraded() {
		return isUpgraded;
	}

	public void setUpgraded(boolean isUpgraded) {
		this.isUpgraded = isUpgraded;
		if (person == 'Y') {
			person = 'Ÿ';
		} else {
			person = 'Ö';
		}
	}
}
