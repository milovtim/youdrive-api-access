package youdrive.today.models;

public class CreditCardModel {
    private String amount;
    private String card_holder;
    private String crypto_packet;
    private String registration_id;

    public CreditCardModel(String registration_id, String amount, String card_holder, String crypto_packet) {
        this.registration_id = registration_id;
        this.amount = Integer.toString(Integer.parseInt(amount) * 100);
        this.card_holder = card_holder;
        this.crypto_packet = crypto_packet;
    }
}
