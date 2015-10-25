package sg.edu.nus.iss.vmcs.system;

public abstract class PropertyAbstractFactory {

	public static final int File = 1;
	public static final int ORACLE = 2;
	public static final int MYSQL = 3;

	public static PropertyAbstractFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {
		case 1:
			return new FilePropertyFactory();
		case 2:
			return new OraclePropertyFactory();
		case 3:
			return new MysqlPropertyFactory();
		}
		return null;
	}

}
