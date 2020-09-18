import HTTP from '.'
import axios from 'axios'


export default {
    fetchCurrencies() {
        return HTTP.get('http://localhost:8080');
    },


    exchangeCurrency(currencyFrom,CurrencyTo,CurrencyToAmount) {
        let data = new FormData();
        data.append("CurrencyFrom",currencyFrom);
        data.append("CurrencyTo",CurrencyTo);
        data.append("CurrencyToAmount",CurrencyToAmount.user);
        return axios.post('http://localhost:8080/getconvertedcurrency',data);
    }
}