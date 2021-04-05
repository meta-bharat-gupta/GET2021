let displayPlan = () => {
    const selectedCurrency = document.querySelector('#currency');
    const currencySymbols = document.querySelectorAll('.currency-symbol');
    currencySymbols.forEach(symbol => {
        if(selectedCurrency.value == 'usd'){
            symbol.innerHTML = "$"
        }
        if(selectedCurrency.value == 'yen'){
            symbol.innerHTML = "¥"
        }
    });

}