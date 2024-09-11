import React, { useEffect, useState } from "react";
import CompanyCard from "./CompanyCard.jsx";
import CompanyFilter from "./CompanyFilter.jsx";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import AppAppBar from "../AppAppBar.jsx"

export default function CompaniesPage() {

    const [companyData, setCompanyData] = useState([]);

    const [loading, setLoading] = useState(true);

    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchCompanies = async () => {
            try {
                const response = await fetch("http://localhost:8080/companies");

                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }

                const data = await response.json();

                setCompanyData(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchCompanies();
    }, []);

    return (
        <>
            <div>
                <AppAppBar />
                <CompanyFilter />

                {loading ? (
                    <p>Loading...</p>
                ) : error ? (
                    <p>Error: {error}</p>
                ) : (
                    <Box mt={4} ml={6}>
                        <Grid container spacing={3}>
                            {companyData.map((company, index) => (
                                <Grid item xs={12} sm={6} md={3} key={index}>
                                    <CompanyCard company={company} />
                                </Grid>
                            ))}
                        </Grid>
                    </Box>
                )}
            </div>
        </>
    );
}
