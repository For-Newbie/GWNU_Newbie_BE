document.addEventListener('DOMContentLoaded', () => {
    const loginBtn = document.getElementById('loginBtn');
    const loginModal = document.getElementById('loginModal');
    const closeModal = document.getElementById('closeModal');

    loginBtn.onclick = () => {
        loginModal.style.display = "block";
    }

    closeModal.onclick = () => {
        loginModal.style.display = "none";
    }

    window.onclick = (event) => {
        if (event.target == loginModal) {
            loginModal.style.display = "none";
        }
    }

    //(실제 로그인 기능은 구현하지 않음)
    document.getElementById('loginForm').onsubmit = (e) => {
        e.preventDefault();
        alert('로그인 기능 테스트.');
    }
});
