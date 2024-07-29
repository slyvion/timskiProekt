import CompanyCard from "./CompanyCard.jsx";
import CompanyFilter from "./CompanyFilter.jsx";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";

export default function CompaniesPage() {
    const companyData = [
        {
            image: 'https://via.placeholder.com/150',
            name: 'Tech Innovators',
            description: 'Leading the way in tech innovation and solutions.',
            rating: 4.8,
            location: 'San Francisco, USA'
        },
        {
            image: 'https://via.placeholder.com/150',
            name: 'Creative Solutions',
            description: 'Providing creative solutions for modern problems.',
            rating: 4.3,
            location: 'Austin, USA'
        },
        {
            image: 'https://via.placeholder.com/150',
            name: 'Green Future',
            description: 'Dedicated to sustainability and environmental impact.',
            rating: 4.6,
            location: 'Seattle, USA'
        },
        {
            image: 'https://via.placeholder.com/150',
            name: 'HealthTech Pros',
            description: 'Innovative solutions in health technology and care.',
            rating: 4.7,
            location: 'Boston, USA'
        }
    ];

    return (
        <>
            <div>
                <CompanyFilter />
                <Box mt={4} ml={6}>
                    <Grid container spacing={3}>
                        {companyData.map((company, index) => (
                            <Grid item xs={12} sm={6} md={3} key={index}>
                                <CompanyCard company={company} />
                            </Grid>
                        ))}
                    </Grid>
                </Box>
            </div>
        </>
    );
}
