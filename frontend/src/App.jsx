
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Layout from './Components/Layout';
import Features from './Components/HomePage/Features';
import Highlights from './Components/HomePage/Highlights';
import Hero from './Components/HomePage/Hero';
import Footer from './Components/HomePage/Footer';
import SignUpUser from './Components/Login/SignUpUser.jsx';
import SignIn from "./Components/Login/SignIn.jsx";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={
                        <>
                            <Hero />
                            <Features />
                            <Highlights />
                            <Footer />
                        </>
                    } />

                </Route>
                <Route path="sign-in" element={<SignIn />} />
                <Route path="sign-up" element={<SignUpUser />} />
            </Routes>
        </Router>
    );
}

export default App;
