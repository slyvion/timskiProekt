import JobPostFilter from "./JobPostFilter.jsx";
import JobPost from "./JobPost.jsx";
import AppAppBar from "../AppAppBar.jsx";
const jobPosts = [
    {
        id: 1,
        title: "Software Engineer",
        companyName: "Tech Innovations",
        logo: "https://via.placeholder.com/80",
        rating: 4.5,
        location: "San Francisco, CA"
    },
    {
        id: 2,
        title: "Product Manager",
        companyName: "Creative Solutions",
        logo: "https://via.placeholder.com/80",
        rating: 4.2,
        location: "New York, NY"
    },
    {
        id: 3,
        title: "UX Designer",
        companyName: "Design Labs",
        logo: "https://via.placeholder.com/80",
        rating: 4.7,
        location: "Austin, TX"
    },
    {
        id: 4,
        title: "Data Scientist",
        companyName: "Data Insights",
        logo: "https://via.placeholder.com/80",
        rating: 4.8,
        location: "Seattle, WA"
    },
    {
        id: 5,
        title: "Marketing Specialist",
        companyName: "Marketing Pros",
        logo: "https://via.placeholder.com/80",
        rating: 4.1,
        location: "Chicago, IL"
    }
];

export default function JobPostPage() {
    return (
        <div>
            <AppAppBar show={false}/>
            <JobPostFilter />
            <span>
                {jobPosts.map((job) => (
                    <JobPost key={job.id} job={job} />
                ))}
                </span>
        </div>
    );
}