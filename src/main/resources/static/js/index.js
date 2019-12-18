const getCards = () = {
    const cardsIndexURL ="/api/cards/balances"
    const response = await fetch(cardsIndexURL)
    const data = await response.json()
    return data;
}
const handleAppendCards = (cards) => {
    const cardsListE1 = document.querySelector('.cards__list')
    cards
        .map(card => `<li>${card.number} | ${card.saldo}</li>`)
        .forEach(cardHtml => cardsListE1.insertAdjacentHTML("beforeend", cardHtml))
}

document.addEventListener("DOMContentLoaded", () => {
    const cardsListE1 = document.querySelector('.cards__list')
    getCards()
        .then(cards => handleAppendCards(cards, cardsListE1));
})