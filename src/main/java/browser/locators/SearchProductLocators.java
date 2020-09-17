package browser.locators;

public class SearchProductLocators {
	public static String homeScreen_label = "//span[contains(text(),'Hello, Sign in')]";
	public static String search_textfield = "//input[@id='twotabsearchtextbox']";
	public static String product_List = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div";
	public static String select_product = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[2]//div[@class='a-section aok-relative s-image-fixed-height']";
	public static String search_button = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']";
	public static String getProduct_deatils = "//span[@id='productTitle']";
    public static String getPriceDeatils = "//tr[@id='priceblock_ourprice_row']//span[@id='priceblock_ourprice']";
    public static String addToCart_button = "//div[@id='desktop_buybox']//span[@id='submit.add-to-cart']";
    public static String cart_button ="//a[@id='hlb-view-cart-announce']"; //
    public static String cart_button1 ="//span[@id='attach-sidesheet-view-cart-button']";
    public static String proceed_to_checkout = "//span[@id='attach-sidesheet-checkout-button']//span[contains(text(),'Proceed to checkout')]";
    public static String cartScreen_productDetails = "//span[@class='a-size-medium sc-product-title a-text-bold']";
    public static String cartScreen_priceDetails = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']";
    
}
