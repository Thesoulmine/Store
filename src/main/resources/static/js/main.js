async function addToCart(data_id, id) {
    let response = await fetch(`http://localhost:8081/api/cart`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: data_id
        })
    });
    let result = await response.json();
}

async function showListings() {
    let response = await fetch(`http://localhost:8081/api/listings`);
    let commits = await response.json();
    let imageResponse = await fetch(`http://localhost:8081/api/listings/images`);
    let imageCommits = await imageResponse.json();
    console.log(imageCommits[0]);
    let li = '';
    let i = 0;
    commits.forEach(listing => {
        li += `
            <div class="col">
                <div class="card h-100">
                    <img src="data:image/jpeg;base64, ${imageCommits[i].content}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${listing.title}</h5>
                        <p class="card-text">${listing.description}</p>
                        <h5 class="card-title">${listing.price}</h5>
                        <button class="btn btn-primary" data-id="${listing.id}" id="addToCart_${listing.id}" onclick="addToCart(this.getAttribute('data-id'), this.getAttribute('id'))">Add to cart</button>
                    </div>
                </div>
            </div>`
        i++;
    });
    document.getElementById("listings").innerHTML = li;
}

window.onload = function() {
    showListings();
};