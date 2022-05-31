const toastTrigger = document.getElementById('h')
const toastLiveExample = document.getElementById('h2')
if (toastTrigger) {
  toastTrigger.addEventListener('click', () => {
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
  })
}