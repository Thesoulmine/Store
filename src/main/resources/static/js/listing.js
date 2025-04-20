async function showListing() {
    let id = window.location.pathname.split("/").pop();
    let response = await fetch(`http://localhost:8080/api/listings/${id}`);
    let listing = await response.json();
    let imageResponse = await fetch(`http://localhost:8080/api/listings/images`);
    let imageCommits = await imageResponse.json();
    let li = '';
    li += `
        <div class="col">
            <div class="card h-100">
                <img src="data:image/jpeg;base64, ${imageCommits[0].content}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${listing.title}</h5>
                    <p class="card-text">${listing.description}</p>
                    <h5 class="card-title">${listing.price}</h5>
                    <button class="btn btn-primary" data-id="${listing.id}" id="addToCart_${listing.id}" onclick="addToCart(this.getAttribute('data-id'), this.getAttribute('id'))">Add to cart</button>
                </div>
            </div>
        </div>`;
    document.getElementById("listing").innerHTML = li;
}

window.onload = function() {
    showListing();
};