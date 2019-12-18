const getCards = () = {
    const cardsIndexURL ="/api/cards/balances"
    const response = await fetch(cardsIndexURL)
    return await response.json();
}
console.log(getCards())