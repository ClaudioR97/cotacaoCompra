package edu.asselvi.item;

public class Item {
	private int cdItem;
	private String dsItem;
	private long qtItem;

	public Item() {
		setCdItem(0);
		setDsItem("");
		setQtItem(0);
	}

	public Item(int cdItem, String dsItem, long qtItem) {
		super();
		this.cdItem = cdItem;
		this.dsItem = dsItem;
		this.qtItem = qtItem;
	}

	public int getCdItem() {
		return cdItem;
	}

	public void setCdItem(int cdItem) {
		this.cdItem = cdItem;
	}

	public String getDsItem() {
		return dsItem;
	}

	public void setDsItem(String dsItem) {
		this.dsItem = dsItem;
	}

	public long getQtItem() {
		return qtItem;
	}

	public void setQtItem(long qtItem) {
		this.qtItem = qtItem;
	}

	@Override
	public String toString() {
		return "Item [Código ="	+ getCdItem() 
				+ "\n Descrição=" + getDsItem() 
				+ "\n Quantidade=" + getQtItem() + "]";
	}
	
	
}
