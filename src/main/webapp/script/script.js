"use strict";

const filters = document.querySelector("#filtres");
const filterButton = document.querySelector("#filterButton");

function showFilters() {
	filters.classList.toggle("hide");
}

document.addEventListener("DOMContentLoaded", () => {
    filterButton.addEventListener("click", showFilters);
})