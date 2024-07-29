import { Card, CardMedia, Typography, Box } from '@mui/material';
import StarIcon from '@mui/icons-material/Star';

export default function JobPost({ job }) {
    return (
        <Card sx={{
            display: 'flex',
            alignItems: 'center',
            p: 2,
            border: '1px solid #ddd',
            boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
            maxWidth: 600, // Adjust width as needed
            mb: 2, // Margin bottom for spacing between cards
            mt: 2 // Margin top for spacing between cards
        }}>
            <CardMedia
                component="img"
                sx={{
                    width: 80, // Adjust width as needed
                    height: 80, // Adjust height as needed
                    objectFit: 'contain'
                }}
                image={job.logo}
                alt={job.companyName}
            />
            <Box sx={{ display: 'flex', flexDirection: 'column', ml: 2, flex: 1 }}>
                <Typography variant="h6" noWrap sx={{ mb: 1 }}>{job.title}</Typography>
                <Box sx={{ display: 'flex', alignItems: 'center', mt: 1 }}>
                    <Typography variant="body2" color="text.secondary" noWrap sx={{ mr: 1 }}>
                        {job.companyName}
                    </Typography>
                    <Box sx={{ display: 'flex', alignItems: 'center', mr: 2 }}>
                        <StarIcon sx={{ color: 'gold', fontSize: 18 }} />
                        <Typography variant="body2" color="text.primary" sx={{ ml: 0.5 }}>
                            {job.rating}
                        </Typography>
                    </Box>
                    <Typography variant="body2" color="text.secondary" noWrap>
                        {job.location}
                    </Typography>
                </Box>
            </Box>
        </Card>
    );
}
