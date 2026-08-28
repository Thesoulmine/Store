async function addListingButton() {
    const form = addListingForm;
    const formData = new FormData();

    const images = [];
    for (let i = 0; i < form.images.files.length; i++) {
        images.push({
            imageType: 'NEW',
            image: i
        });
    }

    const product = {
        title: form.title.value,
        description: form.description.value,
        price: form.price.value,
        isActive: true,
        categories: form.category.value ? [{ id: Number(form.category.value) }] : [],
        images
    };

    formData.append('listing', new Blob([JSON.stringify(product)], {
        type: 'application/json'
    }));

    for (let i = 0; i < form.images.files.length; i++) {
        formData.append('images[' + i + ']', form.images.files[i], form.images.files[i].name);
    }

    const response = await fetch('/api/products', {
        method: 'POST',
        body: formData
    });

    if (!response.ok) {
        console.error('Failed to create product', await response.text());
        return;
    }

    form.reset();
}

async function addCategories() {
    let response = await fetch('/api/listings/categories');
    let commits = await response.json();
    let li = ``;
    commits.forEach(element => {
        li += `<option value="${element.id}">${element.name}</option>`
    });
    document.getElementById('categoryFormSelect').innerHTML = li;
}

window.onload = function() {
    addCategories();
};
