import React from 'react';
import { Card, CardContent, CardMedia, Typography, Box } from '@mui/material';
import StarIcon from '@mui/icons-material/Star';

export default function CompanyCard({ company }) {
    return (
        <Card sx={{ maxWidth: 345 }}>
            <CardMedia
                component="img"
                height="140"
                image={company.image}
                alt={company.name}
            />
            <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                    {company.companyName}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {company.description}
                </Typography>
                <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mt: 2 }}>
                    <Box sx={{ display: 'flex', alignItems: 'center' }}>
                        <StarIcon sx={{ color: 'gold' }} />
                        <Typography variant="body2" color="text.primary" sx={{ ml: 0.5 }}>
                            {company.rating}
                        </Typography>
                    </Box>
                    <Typography variant="body2" color="text.secondary">
                        {company.location}
                    </Typography>
                </Box>
            </CardContent>
        </Card>
    );
}
