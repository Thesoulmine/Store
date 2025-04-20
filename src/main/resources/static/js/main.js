async function addToCart(data_id) {
    let response = await fetch(`http://localhost:8080/api/cart`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            listing: {
                id: data_id
            }
        })
    });
    let result = await response.json();
}

async function showListings() {
    let response = await fetch(`http://localhost:8080/api/listings`);
    let commits = await response.json();
    let li = '';
    let i = 0;
    //
    commits.forEach(listing => {
        li += `
            <a href="http://localhost:8080/listing/${listing.id}">
                <div class="col">
                    <div class="card h-100">
                        <img src="http://localhost:8080/api/listings/images/_MG_2441%20(2)%20(1)%20(1)%20(1).jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${listing.title}</h5>
                            <p class="card-text">${listing.description}</p>
                            <h5 class="card-title">${listing.price}</h5>
                            <button class="btn btn-primary" data-id="${listing.id}"onclick="addToCart(this.getAttribute('data-id'))">Add to cart</button>
                        </div>
                    </div>
                </div>
            </a>`
        i++;
    });
    document.getElementById("listings").innerHTML = li;
}

window.onload = function() {
    showListings();
};