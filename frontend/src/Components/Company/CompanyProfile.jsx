import { useState, useEffect } from "react";
import { Avatar, Typography, Paper, Grid, Tabs, Tab, Box } from "@mui/material";
import { styled } from "@mui/system";
import StarIcon from "@mui/icons-material/Star";
import { useParams } from "react-router-dom";  // Import useParams from react-router-dom

const Root = styled(Paper)(({ theme }) => ({
    padding: theme.spacing(3),
    maxWidth: 600,
    margin: "auto",
    marginTop: theme.spacing(5),
}));

const StyledAvatar = styled(Avatar)(({ theme }) => ({
    width: theme.spacing(12),
    height: theme.spacing(12),
    margin: theme.spacing(2),
}));

const CompanyName = styled(Typography)({
    fontWeight: "bold",
    fontSize: "24px",
});

const Details = styled(Grid)(({ theme }) => ({
    marginTop: theme.spacing(2),
    display: "flex",
    justifyContent: "space-between",
}));

const Rating = styled(Grid)({
    display: "flex",
    alignItems: "center",
});

const Location = styled(Grid)({
    display: "flex",
    alignItems: "center",
});

const TabContent = styled(Box)(({ theme }) => ({
    marginTop: theme.spacing(2),
}));

function CompanyProfile() {
    const { id } = useParams();
    const [value, setValue] = useState(0);
    const [company, setCompany] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    useEffect(() => {
        const fetchCompanyData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/company/${id}`);
                if (!response.ok) {
                    throw new Error("Failed to fetch company data");
                }
                const data = await response.json();
                setCompany(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchCompanyData();
    }, [id]);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <Root>
            <Grid container alignItems="center" justifyContent="center">
                <StyledAvatar src={company.image || "/default-company.png"} />
                <CompanyName>{company.companyName}</CompanyName>
            </Grid>
            <Details container>
                <Rating item>
                    <StarIcon color="secondary" />
                    <Typography>{company.rating || 'N/A'}</Typography>
                </Rating>
                <Location item>
                    <Typography>{company.location}</Typography>
                </Location>
            </Details>
            <Tabs value={value} onChange={handleChange} centered>
                <Tab label="About Us" />
                <Tab label="JobPosts" />
                <Tab label="Reviews" />
            </Tabs>
            <TabContent>
                {value === 0 && <Typography>{company.description}</Typography>}
                {value === 1 && <Typography> JobPosts tuka </Typography>}
                {value === 2 && <Typography> Reviews tuka </Typography>}
            </TabContent>
        </Root>
    ); //todo: fetchni jobposts i reviews
}

export default CompanyProfile;
