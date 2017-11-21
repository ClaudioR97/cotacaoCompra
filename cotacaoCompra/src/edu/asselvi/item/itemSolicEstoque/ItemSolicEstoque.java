package edu.asselvi.item.itemSolicEstoque;

import edu.asselvi.item.Item;

public class ItemSolicEstoque extends Item {
	private int cdItemEstoque;
	private long qtItem;
	private int cdFornecedor;

	public ItemSolicEstoque() {
		super();
	}

	public ItemSolicEstoque(int cdItem, String dsItem, int cdItemEstoque, long qtItem, int cdFornecedor) {
		super(cdItem, dsItem);
		this.cdItemEstoque = cdItemEstoque;
		this.qtItem = qtItem;
		this.cdFornecedor = cdFornecedor;
	}

	public int getCdItemEstoque() {
		return cdItemEstoque;
	}

	public void setCdItemEstoque(int cdItemEstoque) {
		this.cdItemEstoque = cdItemEstoque;
	}

	public long getQtItem() {
		return qtItem;
	}

	public void setQtItem(long qtItem) {
		this.qtItem = qtItem;
	}

	public int getCdFornecedor() {
		return cdFornecedor;
	}

	public void setCdFornecedor(int cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}

	@Override
	public String toString() {
		return "Item solicitado do estoque"
				+ "\n Código no estoque = " + getCdItemEstoque() 
				+ "\n Descrição = " + getDsItem()
				+ "\n Quantidade no estoque = " + getQtItem()
				+ "\n Fonecedor = " + getCdFornecedor() + "]";
	}
	
	

}
