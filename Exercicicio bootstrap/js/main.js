let button = document.getElementById('show')
let modal = document.getElementById('dialog')
const closeButton = document.querySelector('dialog button')

/*button.addEventListener('click', () =>{
    modal.showModal()
})*/

button.onclick = function () {
    modal.show()
    
}
closeButton.onclick = function () {
    modal.close()
}