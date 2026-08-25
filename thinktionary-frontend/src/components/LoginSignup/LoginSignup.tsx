import "./LoginSignup.css";

import {useNavigate} from "react-router-dom";

function LoginSignup() {

    const navigate = useNavigate();

    async function handleSubmit(event: React.SubmitEvent<HTMLFormElement>) {
        event.preventDefault();

        const form = event.currentTarget;
        const formData = new FormData(form);

        const username = formData.get("username");
        const password = formData.get("password");

        console.log("Form Submitted");
        console.log(formData.get("username"));
        console.log(formData.get("password"));

        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                username: username,
                password: password
            }),
        });

        console.log(response);

        const data = await response.json();
        const token = data.token;

        console.log(token);

        if (response.ok) {
            navigate("/login-success");
        }

    }

    return (
        <div className="container">
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input type="text" name="username"/>
                </label>
                <label>
                    Password:
                    <input type="password" name="password"/>
                </label>
                <button type="submit">
                    Submit
                </button>
            </form>
        </div>
    );
}

export default LoginSignup;
