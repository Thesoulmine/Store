async function createPayment() {
    let response = await fetch(`http://localhost:8081/api/cart/payment`, {
        method: 'POST'
    });
    window.location.href = await response.text();
}

async function showCart() {
    let response = await fetch(`http://localhost:8081/api/cart`);
    let commits = await response.json();
    let li = '';
    commits.forEach(product => {
        li += `<tr>
                    <td>${product.listing.title}</td>
                    <td>${product.listing.description}</td>
                    <td>${product.listing.material}</td>
                    <td>${product.listing.price}</td>
               </tr>`
    });
    document.getElementById("cart").innerHTML = li;
}

window.onload = function() {
    showCart();
};