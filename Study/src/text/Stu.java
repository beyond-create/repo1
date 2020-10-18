package text;

import java.io.Serializable;

public class Stu implements Serializable{
	public Stu(int snumber,String sname,int age,double money) {
		setSnumber(snumber);
		setSname(sname);
		setAge(age);
		setMoney(money);
	}
	public Stu() {
		super();
	}
	private int snumber;
	private String sname;
	private int age;
	private double money;
	public int getSnumber() {
		return snumber;
	}
	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + snumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu other = (Stu) obj;
		if (age != other.age)
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (snumber != other.snumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stu [snumber=" + snumber + ", sname=" + sname + ", age=" + age + ", money=" + money + "]";
	}
}
